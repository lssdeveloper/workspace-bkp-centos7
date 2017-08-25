package br.com.acangasolucoes.erp.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.acangasolucoes.erp.model.RamoAtividade;

public class RamoAtividadeConverter_New implements Converter {

    private List<RamoAtividade> listaRamoAtividades;

    public RamoAtividadeConverter_New(List<RamoAtividade> listaRamoAtividades) {
        this.listaRamoAtividades = listaRamoAtividades;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        Long id = Long.valueOf(value);
        
        for (RamoAtividade ramoAtividade: listaRamoAtividades) {
            if (id.equals(ramoAtividade.getId())) {
                return ramoAtividade;
            }
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        
        RamoAtividade ramoAtividade = (RamoAtividade) value;
        
        return ramoAtividade.getId().toString();
    }
}
