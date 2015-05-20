package model.gui.component;

public abstract class Screen {
	private List<ComponentView> componentViews;
	
	public Screen() {
		
	}
	
	public void setComponentViews(List<ComponentViews> componentViews) {
		this.componentViews = componentViews;
	}
	
	public void render() {
		for (ComponentView cV : this.componentViews) {
			cV.render();
		}
	}
}