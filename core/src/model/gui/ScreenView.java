package model.gui;

public abstract class ScreenView {
	private List<ComponentView> componentViews;
	
	public ScreenView() {
		
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