package es.proojec.domain.models;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class CompanyDTO extends ObjectDTO {

    private ThesisDTO favouriteThesis;

    public ThesisDTO getFavouriteThesis() {
        return favouriteThesis;
    }

    public void setFavouriteThesis(ThesisDTO favouriteThesis) {
        this.favouriteThesis = favouriteThesis;
    }
}
