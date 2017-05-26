package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.AcanoType;
import org.dom4j.Node;

/**
 * Created by Vega Zhou on 2017/5/22.
 */
@AcanoType("callProfile")
public class CallProfile extends AcanoObject {

    private int participantLimit;
    private boolean messageBoardEnabled;
    private String recordingMode;
    private String streamingMode;


    @Override
    public String getNewObjectPath() {
        return "/callProfiles";
    }

    @Override
    public String getQueryPath() {
        return "/callProfiles";
    }

    @Override
    public void parseBody(Node bodyNode) {
        participantLimit = readIntValue(bodyNode.selectSingleNode("participantLimit"));
        messageBoardEnabled = readBooleanValue(bodyNode.selectSingleNode("messageBoardEnabled"));
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    public boolean isMessageBoardEnabled() {
        return messageBoardEnabled;
    }

    public void setMessageBoardEnabled(boolean messageBoardEnabled) {
        this.messageBoardEnabled = messageBoardEnabled;
    }

    public String getRecordingMode() {
        return recordingMode;
    }

    public String getStreamingMode() {
        return streamingMode;
    }

    public void setStreamingMode(String streamingMode) {
        this.streamingMode = streamingMode;
    }

    public void setRecordingMode(String recordingMode) {
        this.recordingMode = recordingMode;
    }
}