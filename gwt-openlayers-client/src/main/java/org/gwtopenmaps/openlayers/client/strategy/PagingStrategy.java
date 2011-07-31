package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Maciej Jezierski - Pinocchio
 *
 */
public class PagingStrategy extends Strategy {

	public boolean activate() {
		return PagingStrategyImpl.activate(this.getJSObject());
	}
	
	public boolean deactivate() {
		return PagingStrategyImpl.deactivate(this.getJSObject());
	}
	
	public int pageCount() {
		return PagingStrategyImpl.pageCount(this.getJSObject());
	}
	
	public int pageNum() {
		return PagingStrategyImpl.pageNum(this.getJSObject());
	}
	
	public int pageLength() {
		return PagingStrategyImpl.pageLength(this.getJSObject());
	}
	
	public int pageLength(int length) {
		return PagingStrategyImpl.pageLength(this.getJSObject(), length);
	}
	
	public boolean pageNext() {
		return PagingStrategyImpl.pageNext(this.getJSObject());
	}
	
	public boolean pagePrevious() {
		return PagingStrategyImpl.pagePrevious(this.getJSObject());
	}
 	
	public PagingStrategy(JSObject strategy) {
		super(strategy);
	}

	public PagingStrategy() {
		this(PagingStrategyImpl.create());
	}
}
