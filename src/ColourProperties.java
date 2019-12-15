import java.util.ArrayList;

public class ColourProperties {

    public ColourProperties(Integer startX, Integer stopX, Integer startY, Integer stopY, String colour) {
        this.startX = startX;
        this.stopX = stopX;
        this.startY = startY;
        this.stopY = stopY;
        this.colour = colour;
    }

    private Integer startX;
    private Integer stopX;
    private Integer startY;
    private Integer stopY;
    private String colour;

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

    public String getColour() {
        return colour;
    }

    static public ArrayList<ColourProperties> generateCoordinates() {
        ArrayList<ColourProperties> cordinates = new ArrayList<>();
        cordinates.add(new ColourProperties(80, 150, 80, 150, "Bia³y"));
        cordinates.add(new ColourProperties(300, 370, 80, 150, "¯ó³ty"));
        cordinates.add(new ColourProperties(530, 610, 80, 150, "Niebieski"));
        cordinates.add(new ColourProperties(750, 830, 80, 150, "Zielony"));
        cordinates.add(new ColourProperties(980, 1060, 80, 150, "Ró¿owy"));
        cordinates.add(new ColourProperties(1200, 1230, 80, 150, "Czerowny"));
        cordinates.add(new ColourProperties(80, 150, 650, 700, "Czarny"));

        return cordinates;
    }
}
