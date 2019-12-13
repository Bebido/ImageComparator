public class ImageCordinates {

    public ImageCordinates(Integer startX, Integer stopX, Integer startY, Integer stopY) {
        this.startX = startX;
        this.stopX = stopX;
        this.startY = startY;
        this.stopY = stopY;
    }

    private Integer startX;
    private Integer stopX;
    private Integer startY;
    private Integer stopY;

    public Integer getStartX() {
        return startX;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    public Integer getStopX() {
        return stopX;
    }

    public void setStopX(Integer stopX) {
        this.stopX = stopX;
    }

    public Integer getStartY() {
        return startY;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    public Integer getStopY() {
        return stopY;
    }

    public void setStopY(Integer stopY) {
        this.stopY = stopY;
    }
}
