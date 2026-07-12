package com.markerboard;

import android.content.Context;
import android.content.SharedPreferences;

public class SheetConfig {

    private static final String PREFS_NAME = "markerboard_prefs";
    private static final String KEY_SHEET_ID       = "sheet_id";
    private static final String KEY_API_KEY        = "api_key";
    private static final String KEY_SHEET_NAME     = "sheet_name";
    private static final String KEY_TASK_COL       = "task_col";
    private static final String KEY_DONE_COL       = "done_col";
    private static final String KEY_REFRESH_SEC    = "refresh_sec";

    public String sheetId;
    public String apiKey;
    public String sheetName;
    public String taskCol;
    public String doneCol;
    public int    refreshSeconds;

    public static SheetConfig load(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SheetConfig c = new SheetConfig();
        c.sheetId       = prefs.getString(KEY_SHEET_ID, "");
        c.apiKey        = prefs.getString(KEY_API_KEY, "");
        c.sheetName     = prefs.getString(KEY_SHEET_NAME, "Sheet1");
        c.taskCol       = prefs.getString(KEY_TASK_COL, "A");
        c.doneCol       = prefs.getString(KEY_DONE_COL, "B");
        c.refreshSeconds = prefs.getInt(KEY_REFRESH_SEC, 30);
        return c;
    }

    public void save(Context ctx) {
        ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_SHEET_ID,    sheetId)
            .putString(KEY_API_KEY,     apiKey)
            .putString(KEY_SHEET_NAME,  sheetName)
            .putString(KEY_TASK_COL,    taskCol.toUpperCase().trim())
            .putString(KEY_DONE_COL,    doneCol.toUpperCase().trim())
            .putInt(KEY_REFRESH_SEC,    refreshSeconds)
            .apply();
    }

    public boolean isConfigured() {
        return sheetId != null && !sheetId.isEmpty()
            && apiKey  != null && !apiKey.isEmpty();
    }

    /** Builds the Sheets API v4 URL for fetching the configured range. */
    public String buildApiUrl() {
        // Fetch columns A–Z of the sheet to cover any column mapping
        String range = sheetName + "!" + taskCol + ":" + doneCol;
        return "https://sheets.googleapis.com/v4/spreadsheets/"
                + sheetId
                + "/values/"
                + android.net.Uri.encode(range)
                + "?key=" + apiKey;
    }
}
