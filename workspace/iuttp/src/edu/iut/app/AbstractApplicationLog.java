package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	/** TP1 : Tableau au sens des collections **/
	protected ArrayList<IApplicationLogListener> listeners;
	
	
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}
	
    public IApplicationLogListener[] getpplicationLogListeners() {
		return listeners;
	}
    public void addListener(IApplicationLogListener listener){
		this.listeners.add(listener);
	}

	/** TP1 : Fonction venant de l'interface par héritage 
     * @return */
	public abstract void setMessage(String message);

	/** Listener action */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
