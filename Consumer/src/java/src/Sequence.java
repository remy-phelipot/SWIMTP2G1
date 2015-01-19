/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author frankgouineau
 */
public class Sequence {
    
  private int begin;
  private int dataSize;
  private int end;
  private float processingTime;
  private int requestPerSecond;
  
  
  //private String provider;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public float getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(float processingTime) {
        this.processingTime = processingTime;
    }

    public int getRequestPerSecond() {
        return requestPerSecond;
    }

    public void setRequestPerSecond(int requestPerSecond) {
        this.requestPerSecond = requestPerSecond;
    }
  
  
  
    
}
