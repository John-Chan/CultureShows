package org.gwtgaebook.CultureShows.client;

import org.gwtgaebook.CultureShows.client.widget.HeaderPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.client.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class MainPresenter extends
		Presenter<MainPresenter.MyView, MainPresenter.MyProxy> implements
		MainUiHandlers {

	@ProxyStandard
	public interface MyProxy extends Proxy<MainPresenter> {
	}

	public interface MyView extends View, HasUiHandlers<MainUiHandlers> {
	}

	public static final Object TYPE_RevealHeaderContent = new Object();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_RevealPageContent = new Type<RevealContentHandler<?>>();

	private final PlaceManager placeManager;
	private final DispatchAsync dispatcher;
	private ClientState clientState;

	private final HeaderPresenter headerPresenter;

	@Inject
	public MainPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final PlaceManager placeManager,
			final DispatchAsync dispatcher,
			final HeaderPresenter headerPresenter, final ClientState clientState) {
		super(eventBus, view, proxy);
		this.placeManager = placeManager;
		this.dispatcher = dispatcher;
		this.headerPresenter = headerPresenter;
		this.clientState = clientState;

		getView().setUiHandlers(this);

	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	public void onReveal() {
		super.onReveal();
		Main.logger.info("MainPresenter onReveal");

		setInSlot(TYPE_RevealHeaderContent, headerPresenter);
	}

}
