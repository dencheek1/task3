package by.vsu.lab.task3.gem;

public class Gem {
    private String id;
    private GemColorType color;
    private GemPreciousnessType preciousness;
    private String origin;
    private String name;
    private Double opacity;
    private Integer face = null;
    private Double value;

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getId() {
	return id;
    }

    public void setColor(GemColorType color) {
	this.color = color;
    }

    public GemColorType getColor() {
	return color;
    }

    public void setPreciousness(GemPreciousnessType preciousness) {
	this.preciousness = preciousness;
    }

    public GemPreciousnessType getPreciousness() {
	return preciousness;
    }

    public void setOrigin(String origin) {
	this.origin = origin;
    }

    public String getOrigin() {
	return origin;
    }

    public void setOpacity(Double opacity) {
	this.opacity = opacity;
    }

    public Double getOpacity() {
	return opacity;
    }

    public void setFace(int face) {
	this.face = face;
    }

    public Integer getFace() {
	return face;
    }

    public void setValue(Double value) {
	this.value = value;
    }

    public Double getValue() {
	return value;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Gem ID:").append(id).append("\n");
	builder.append("name ").append(name).append("\n");
	builder.append("origin ").append(origin).append("\n");
	builder.append("preciousness ").append(preciousness).append("\n");
	builder.append("\tcolor ").append(color).append("\n");
	builder.append("\topacity ").append(opacity).append("\n");
	if (face != null)
	    builder.append("\tface ").append(face).append("\n");
	builder.append("value ").append(value).append("\n");
	return builder.toString();
    }
}
