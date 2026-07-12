<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/rootLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/board_bg"
    tools:context=".MainActivity">

    <!-- Subtle board texture lines (drawn via BoardSurfaceView) -->
    <com.markerboard.BoardSurfaceView
        android:id="@+id/boardSurface"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

    <!-- Top status bar — very subtle, hugs the top edge -->
    <LinearLayout
        android:id="@+id/statusBar"
        android:layout_width="match_parent"
        android:layout_height="@dimen/header_height"
        android:layout_gravity="top"
        android:orientation="horizontal"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:gravity="center_vertical"
        android:alpha="0.55">

        <View
            android:id="@+id/statusDot"
            android:layout_width="@dimen/status_dot_size"
            android:layout_height="@dimen/status_dot_size"
            android:background="@drawable/status_dot"
            android:backgroundTint="@color/status_loading" />

        <TextView
            android:id="@+id/statusText"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginStart="8dp"
            android:textColor="@color/ink_black"
            android:textSize="11sp"
            android:fontFamily="monospace"
            android:text="Connecting…" />

        <TextView
            android:id="@+id/lastUpdatedText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@color/ink_black"
            android:textSize="10sp"
            android:fontFamily="monospace"
            android:text="" />

    </LinearLayout>

    <!-- Main task scroll area -->
    <ScrollView
        android:id="@+id/taskScrollView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingTop="@dimen/header_height"
        android:paddingStart="@dimen/board_padding"
        android:paddingEnd="@dimen/board_padding"
        android:paddingBottom="@dimen/board_padding"
        android:scrollbars="none"
        android:overScrollMode="never"
        android:clipToPadding="false">

        <LinearLayout
            android:id="@+id/taskContainer"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:paddingTop="16dp" />

    </ScrollView>

    <!-- Empty state -->
    <TextView
        android:id="@+id/emptyText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="@string/no_tasks"
        android:textColor="@color/board_frame"
        android:textSize="22sp"
        android:fontFamily="monospace"
        android:visibility="gone" />

    <!-- Long-press hint — fades after first interaction -->
    <TextView
        android:id="@+id/hintText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_marginBottom="16dp"
        android:layout_marginEnd="20dp"
        android:text="@string/tap_settings"
        android:textColor="@color/board_frame"
        android:textSize="10sp"
        android:fontFamily="monospace"
        android:alpha="0.5" />

</FrameLayout>
