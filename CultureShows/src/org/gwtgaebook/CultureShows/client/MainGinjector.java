package org.gwtgaebook.CultureShows.client;

import org.gwtgaebook.CultureShows.client.guide.GuideModule;
import org.gwtgaebook.CultureShows.client.guide.GuidePresenter;
import org.gwtgaebook.CultureShows.client.landing.LandingModule;
import org.gwtgaebook.CultureShows.client.landing.LandingPresenter;
import org.gwtgaebook.CultureShows.client.locations.LocationModule;
import org.gwtgaebook.CultureShows.client.locations.LocationPresenter;
import org.gwtgaebook.CultureShows.client.page.PageModule;
import org.gwtgaebook.CultureShows.client.page.PagePresenter;
import org.gwtgaebook.CultureShows.client.performances.PerformanceModule;
import org.gwtgaebook.CultureShows.client.performances.PerformancePresenter;
import org.gwtgaebook.CultureShows.client.resources.Resources;
import org.gwtgaebook.CultureShows.client.resources.Translations;
import org.gwtgaebook.CultureShows.client.shows.ShowModule;
import org.gwtgaebook.CultureShows.client.shows.ShowPresenter;
import org.gwtgaebook.CultureShows.client.widget.WidgetModule;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyFailureHandler;

//DispatchAsyncModule.class,
@GinModules({ MainModule.class, WidgetModule.class, LandingModule.class,
		PageModule.class, PerformanceModule.class, ShowModule.class,
		LocationModule.class, GuideModule.class })
public interface MainGinjector extends Ginjector {
	EventBus getEventBus();

	PlaceManager getPlaceManager();

	ProxyFailureHandler getProxyFailureHandler();

	Resources getResources();

	Translations getTranslations();

	SignedInGatekeeper getSignedInGatekeeper();

	Provider<MainPresenter> getMainPresenter();

	Provider<LandingPresenter> getLandingPresenter();

	Provider<PagePresenter> getContentPresenter();

	Provider<PerformancePresenter> getPerformancePresenter();

	AsyncProvider<GuidePresenter> getGuidePresenter();

	AsyncProvider<ShowPresenter> getShowPresenter();

	AsyncProvider<LocationPresenter> getLocationPresenter();

}