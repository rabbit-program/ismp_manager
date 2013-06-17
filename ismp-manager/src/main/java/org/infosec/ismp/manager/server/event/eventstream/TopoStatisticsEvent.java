/**
 * TopoStatisticsEvent.java
 */
package org.infosec.ismp.manager.server.event.eventstream;

import java.sql.Timestamp;
 
/**
 * 定义拓扑统计计算事件
 * @author Jianyu Shen
 * 
 *         2009-6-4 上午11:16:24
 */
public class TopoStatisticsEvent extends BaseEvent {

    /**
     * 保存对归并后事件进行topo统计后的事件
     */
    public TopoStatisticsEvent() {
        super();
    }

    /**
     * 设备中的事件量初值
     */
    private Integer init_value;

    /**
     * 设备中的事件总量
     */
    private Integer total_value;

    /**
     * 设备中的事件量当前值
     */
    private Integer curr_value;

    /**
     * 设备ID，唯一标识一个设备
     */
    private Integer faci_id;

    /**
     * 设备名称
     */
    private String faci_name;

    /**
     * 事件量增长幅度
     */
    private Double range;

    /**
     * 进行事件监测分析时当前切点的时间
     */
    private Timestamp time;

    /**
     * 设备中的事件量最大值
     */
    private Integer max_value;

    /**
     * 设备中的事件量最小值
     */
    private Integer min_value;

    /**
     * 事件冗余度
     */
    private Float redundance;

    /**
     * 事件类型，可能是一系列类型的集合
     */
    private String type;

    /**
     * 设备可用度
     */
    private Double faci_avai;

    public Integer getInit_value() {
        return init_value;
    }
 
    public void setInit_value(Integer vInit_value) {
        init_value = vInit_value;
    }

    public Integer getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Integer vTotal_value) {
        total_value = vTotal_value;
    }

    public Integer getCurr_value() {
        return curr_value;
    }

    public void setCurr_value(Integer vCurr_value) {
        curr_value = vCurr_value;
    }

    public Integer getFaci_id() {
        return faci_id;
    }

    public void setFaci_id(Integer vFaci_id) {
        faci_id = vFaci_id;
    }

    public String getFaci_name() {
        return faci_name;
    }

    public void setFaci_name(String vFaci_name) {
        faci_name = vFaci_name;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double vRange) {
        range = vRange;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp vTime) {
        time = vTime;
    }

    public Integer getMax_value() {
        return max_value;
    }

    public void setMax_value(Integer vMax_value) {
        max_value = vMax_value;
    }

    public Integer getMin_value() {
        return min_value;
    }

    public void setMin_value(Integer vMin_value) {
        min_value = vMin_value;
    }

    public Float getRedundance() {
        return redundance;
    }

    public void setRedundance(Float vRedundance) {
        redundance = vRedundance;
    }

    public String getType() {
        return type;
    }

    public void setType(String vType) {
        type = vType;
    }

    public Double getFaci_avai() {
        return faci_avai;
    }

    public void setFaci_avai(Double vFaci_avai) {
        faci_avai = vFaci_avai;
    }

}
