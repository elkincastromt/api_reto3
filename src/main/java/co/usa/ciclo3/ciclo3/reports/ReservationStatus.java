package co.usa.ciclo3.ciclo3.reports;

public class ReservationStatus {
    private Integer completed;
    private Integer Cancelled;

    public ReservationStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        Cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return Cancelled;
    }

    public void setCancelled(Integer cancelled) {
        Cancelled = cancelled;
    }
}
