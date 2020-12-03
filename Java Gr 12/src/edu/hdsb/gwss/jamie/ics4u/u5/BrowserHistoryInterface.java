/**
 * Browser History Interface.
 *
 * @author Wm.Muir
 * @version 2020-21.Q1
 */
package edu.hdsb.gwss.jamie.ics4u.u5;

import java.net.URL;

public interface BrowserHistoryInterface {

    /**
     * Returns the previously visited URL, relative to the current URL.
     *
     * @return the URL object last visited, relative to the current URL.  NULL if there is no history.
     */
    public URL back();

    /**
     * Returns the previously visited URL, relative to the recent back() history.
     * 
     * With an internet browser, forward moves you forward a page. It only works 
     * if you have previously used the back button.
     *
     * @return the URL Object last visited, relative to the recent back() history.  NULL if there is no back history.
     */
    public URL forward();

    /**
     * A new URL visit, which is to be added to the browser history.
     * 
     * @param value the URL visiting
     */
    public void visit( URL value );

}
