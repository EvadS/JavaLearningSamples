package som.se.sample;

import java.time.Instant;

public class NodeInfoContainer {

    String clientId;
    String fileName;
    Instant lastUpdateDate;

    public NodeInfoContainer() {
    }

    public NodeInfoContainer(String clientId, String fileName, Instant lastUpdateDate) {
        this.clientId = clientId;
        this.fileName = fileName;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "NodeInfoContainer{" +
                "clientId='" + clientId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
