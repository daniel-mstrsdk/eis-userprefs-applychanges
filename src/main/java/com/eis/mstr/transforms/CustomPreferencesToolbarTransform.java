package com.eis.mstr.transforms;

import com.microstrategy.utils.StringUtils;
import com.microstrategy.web.app.beans.AppContext;
import com.microstrategy.web.app.transforms.PreferencesToolbarTransform;
import com.microstrategy.web.beans.MarkupOutput;
import com.microstrategy.web.preferences.Preferences;
import com.microstrategy.web.preferences.PreferencesException;

public class CustomPreferencesToolbarTransform extends PreferencesToolbarTransform {

    @Override
    public void renderPulldownButton(MarkupOutput markupOutput) {
        try {
            AppContext _appCtx = this.getAppContext();
            if (_appCtx != null) {
                Preferences _prefs = _appCtx.getPreferences();
                if (_prefs != null) {
                    String DEFAULT_APPLY_OPTION_PREF = "defaultApplyOption";
                    String APPLY_TO_CUR_PROJECT_VAL = "0";

                    String _defaultApplyOption = _prefs.getValue(DEFAULT_APPLY_OPTION_PREF);
                    if (StringUtils.isNotEqual(_defaultApplyOption, APPLY_TO_CUR_PROJECT_VAL))
                        _prefs.setValue(DEFAULT_APPLY_OPTION_PREF, APPLY_TO_CUR_PROJECT_VAL);
                }
            }
        } catch (PreferencesException pe) {
            pe.printStackTrace();
        }

        super.renderPulldownButton(markupOutput);
    }
}
