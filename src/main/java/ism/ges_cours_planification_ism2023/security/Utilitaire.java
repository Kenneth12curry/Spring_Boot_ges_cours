package ism.ges_cours_planification_ism2023.security;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Component
public class Utilitaire {

    public MappingJacksonValue getFilter(Object o, String filterName, String propertyName) {
        // Crée un filtre pour exclure la propriété spécifiée
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(propertyName);

        // Crée un fournisseur de filtres et ajoute le filtre spécifié avec le nom du filtre
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName, filter);

        // Crée un objet MappingJacksonValue avec l'objet d'origine
        MappingJacksonValue filteredValue = new MappingJacksonValue(o);

        // Définit le fournisseur de filtres sur l'objet MappingJacksonValue
        filteredValue.setFilters(filterProvider);

        return filteredValue;
    }

    public MappingJacksonValue getFilterList(Object o, String filterName1, String propertyName1, String filterName2, String propertyName2) {
        // Crée un premier filtre pour exclure la première propriété spécifiée
        SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.serializeAllExcept(propertyName1);
        // Crée un deuxième filtre pour exclure la deuxième propriété spécifiée
        SimpleBeanPropertyFilter filter2 = SimpleBeanPropertyFilter.serializeAllExcept(propertyName2);

        // Crée un fournisseur de filtres et ajoute les deux filtres avec leurs noms respectifs
        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter(filterName1, filter1)
                .addFilter(filterName2, filter2);

        // Crée un objet MappingJacksonValue avec l'objet d'origine
        MappingJacksonValue filteredValue = new MappingJacksonValue(o);

        // Définit le fournisseur de filtres sur l'objet MappingJacksonValue
        filteredValue.setFilters(filterProvider);

        return filteredValue;
    }

}
