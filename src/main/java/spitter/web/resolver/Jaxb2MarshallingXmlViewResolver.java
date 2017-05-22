package spitter.web.resolver;

import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Locale;

/**
 * Created by nkim on 5/22/2017.
 */
public class Jaxb2MarshallingXmlViewResolver implements ViewResolver {
    private Marshaller marshaller;

    public Jaxb2MarshallingXmlViewResolver(Marshaller marshaller){
        this.marshaller = marshaller;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception{
        MarshallingView view = new MarshallingView();
        view.setMarshaller(marshaller);
        return view;
    }
}

