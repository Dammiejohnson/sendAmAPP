package africa.semicolon.sendAm.data.models;

import java.time.LocalDateTime;

public class Status {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private String status;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Status{");
        sb.append("dateTime=").append(dateTime);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
