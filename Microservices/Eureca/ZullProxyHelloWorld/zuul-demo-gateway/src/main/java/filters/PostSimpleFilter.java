package filters;



import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.exception.ZuulException;
import filters.PreSimpleFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PostSimpleFilter extends ZuulFilter  {

    private static Logger log = LoggerFactory.getLogger(PreSimpleFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("post %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
