package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@AcanoType("call")
public class Call extends AcanoObject {

    private String coSpace;
    protected boolean isCoSpaceDirty = false;

    private int durationSeconds;
    protected boolean isDurationSecondsDirty = false;

    private int numCallLegs;
    protected boolean isNumCallLegsDirty = false;

    private int maxCallLegs;
    protected boolean isMaxCallLegsDirty = false;

    private String presenterCallLeg;
    protected boolean isPresenterCallLegDirty = false;

    private boolean locked;
    protected boolean isLockedDirty = false;

    private boolean allowAllMuteSelf;
    protected boolean isAllowAllMuteSelfDirty = false;

    private boolean allowAllPresentationContribution;
    protected boolean isAllowAllPresentationContributionDirty = false;

    private boolean joinAudioMuteOverride;
    protected boolean isJoinAudioMuteOverrideDirty = false;

    private String messageText;
    protected boolean isMessageTextDirty = false;

    private boolean activeWhenEmpty;
    protected boolean isActiveWhenEmptyDirty = false;


    @Override
    public String getNewObjectPath() {
        return "/calls";
    }

    @Override
    public String getQueryPath() {
        return "/calls";
    }

    @Override
    public void parseBody(Node bodyNode) {
        id = readTextValue(bodyNode.selectSingleNode("@id"));
        coSpace = readTextValue(bodyNode.selectSingleNode("coSpace"));
        durationSeconds = readIntValue(bodyNode.selectSingleNode("durationSeconds"));
        numCallLegs = readIntValue(bodyNode.selectSingleNode("numCallLegs"));
        maxCallLegs = readIntValue(bodyNode.selectSingleNode("maxCallLegs"));
        presenterCallLeg = readTextValue(bodyNode.selectSingleNode("presenterCallLeg"));
        locked = readBooleanValue(bodyNode.selectSingleNode("locked"));
        allowAllMuteSelf = readBooleanValue(bodyNode.selectSingleNode("allowAllMuteSelf"));
        allowAllPresentationContribution = readBooleanValue(bodyNode.selectSingleNode("allowAllPresentationContribution"));
        joinAudioMuteOverride = readBooleanValue(bodyNode.selectSingleNode("joinAudioMuteOverride"));
        messageText = readTextValue(bodyNode.selectSingleNode("messageText"));
        activeWhenEmpty = readBooleanValue(bodyNode.selectSingleNode("activeWhenEmpty"));
    }

    public String getCoSpace() {
        return coSpace;
    }

    public void setCoSpace(String coSpace) {
        this.coSpace = coSpace;
        isCoSpaceDirty = true;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
        isDurationSecondsDirty = true;
    }

    public int getNumCallLegs() {
        return numCallLegs;
    }

    public void setNumCallLegs(int numCallLegs) {
        this.numCallLegs = numCallLegs;
        isNumCallLegsDirty = true;
    }

    public int getMaxCallLegs() {
        return maxCallLegs;
    }

    public void setMaxCallLegs(int maxCallLegs) {
        this.maxCallLegs = maxCallLegs;
        isMaxCallLegsDirty = true;
    }

    public String getPresenterCallLeg() {
        return presenterCallLeg;
    }

    public void setPresenterCallLeg(String presenterCallLeg) {
        this.presenterCallLeg = presenterCallLeg;
        isPresenterCallLegDirty = true;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
        isLockedDirty = true;
    }

    public boolean isAllowAllMuteSelf() {
        return allowAllMuteSelf;
    }

    public void setAllowAllMuteSelf(boolean allowAllMuteSelf) {
        this.allowAllMuteSelf = allowAllMuteSelf;
        isAllowAllMuteSelfDirty = true;
    }

    public boolean isAllowAllPresentationContribution() {
        return allowAllPresentationContribution;
    }

    public void setAllowAllPresentationContribution(boolean allowAllPresentationContribution) {
        this.allowAllPresentationContribution = allowAllPresentationContribution;
        isAllowAllPresentationContributionDirty = true;
    }

    public boolean isJoinAudioMuteOverride() {
        return joinAudioMuteOverride;
    }

    public void setJoinAudioMuteOverride(boolean joinAudioMuteOverride) {
        this.joinAudioMuteOverride = joinAudioMuteOverride;
        isJoinAudioMuteOverrideDirty = true;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
        isMessageTextDirty = true;
    }

    public boolean isActiveWhenEmpty() {
        return activeWhenEmpty;
    }

    public void setActiveWhenEmpty(boolean activeWhenEmpty) {
        this.activeWhenEmpty = activeWhenEmpty;
        isActiveWhenEmptyDirty = true;
    }
}
