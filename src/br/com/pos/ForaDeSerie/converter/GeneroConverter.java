package br.com.pos.ForaDeSerie.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.pos.ForaDeSerie.model.DAO.GeneroDAO;
import br.com.pos.ForaDeSerie.model.entity.Genero;


@FacesConverter("generoConverter")
public class GeneroConverter implements Converter {
	@Override
    public Object getAsObject(FacesContext contet, UIComponent component, String value) {
        if(value.equals(null) || value.equals("null") || value.equals("") || value.equals("Selecione o gênero"))
            return null;
        try{
         GeneroDAO tipoLocalDAO = new GeneroDAO();
         System.out.println(value);
         Genero resultado =tipoLocalDAO.buscarGeneroById(Integer.valueOf(value));
            return resultado;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contet, UIComponent component, Object value) {
        if(value==null || value.equals(""))
            return null;
             return String.valueOf(((Genero)value).getIdGenero());
    }
}
