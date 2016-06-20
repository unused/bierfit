package bierfit.mybierfit;

import java.util.Date;

/**
 * Created by kosha on 20/06/2016.
 */
public class ConsumeEvent {

    private int analog_reading;
    private int voltage_reading_in_mv;
    private int fsr_resistance_in_ohms;
    private int conductance_in_micromhos;
    private int force_in_newtons;
    private Date consumed_at;
    private Date created_at;
    private Date updated_at;
    private int user_id;
    private boolean processed = false;

    public int getAnalog_reading() {
        return analog_reading;
    }

    public void setAnalog_reading(int analog_reading) {
        this.analog_reading = analog_reading;
    }

    public int getVoltage_reading_in_mv() {
        return voltage_reading_in_mv;
    }

    public void setVoltage_reading_in_mv(int voltage_reading_in_mv) {
        this.voltage_reading_in_mv = voltage_reading_in_mv;
    }

    public int getFsr_resistance_in_ohms() {
        return fsr_resistance_in_ohms;
    }

    public void setFsr_resistance_in_ohms(int fsr_resistance_in_ohms) {
        this.fsr_resistance_in_ohms = fsr_resistance_in_ohms;
    }

    public int getConductance_in_micromhos() {
        return conductance_in_micromhos;
    }

    public void setConductance_in_micromhos(int conductance_in_micromhos) {
        this.conductance_in_micromhos = conductance_in_micromhos;
    }

    public int getForce_in_newtons() {
        return force_in_newtons;
    }

    public void setForce_in_newtons(int force_in_newtons) {
        this.force_in_newtons = force_in_newtons;
    }

    public Date getConsumed_at() {
        return consumed_at;
    }

    public void setConsumed_at(Date consumed_at) {
        this.consumed_at = consumed_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public ConsumeEvent(int analog_reading, int voltage_reading_in_mv, int fsr_resistance_in_ohms,
                        int conductance_in_micromhos, int force_in_newtons, Date consumed_at,
                        Date created_at, Date updated_at, int user_id, boolean processed) {
        this.analog_reading = analog_reading;
        this.voltage_reading_in_mv = voltage_reading_in_mv;
        this.fsr_resistance_in_ohms = fsr_resistance_in_ohms;
        this.conductance_in_micromhos = conductance_in_micromhos;
        this.force_in_newtons = force_in_newtons;
        this.consumed_at = consumed_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.processed = processed;
    }

    public ConsumeEvent() {

    }

}
