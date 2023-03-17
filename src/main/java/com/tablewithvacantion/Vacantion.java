package com.tablewithvacantion;

import com.tablewithvacantion.Grade;
import com.tablewithvacantion.ResourceManager;
import org.jsoup.Jsoup;
/* Класс описывающий вакансию
Все сеттеры принмаю обджект из HTTPClient из парсинга JSON
 */
public class Vacantion {

    String nameOfVacantion;
    int idVacantion;
    String descriptionOfVacantion;
    String commentToVacantion;
    String project;
    String requirementsToVacantion;
    String stackOfVacantion;
    String gradeOfVacantion;
    String expirienceOfVacantion;
    String addressOfVacantion;
    String workFormatOfVacantion;
    String resourceManagerOfVacantion;
    String categoryOfVacanion;
    String geographyOfVacantion;

    public void setCategoryOfVacanion(Object categoryOfVacanion) {
        if (categoryOfVacanion == "" | categoryOfVacanion == null) {
            this.categoryOfVacanion = "-";
        } else {
            this.categoryOfVacanion = Category.getParametrs(Integer.parseInt(categoryOfVacanion.toString()));
        }
    }

    public void setNameOfVacantion(Object nameOfVacantion) {
        if (nameOfVacantion == null){
            this.nameOfVacantion = "-";
        } else {
            this.nameOfVacantion = (String) nameOfVacantion;
        }
    }

    public void setIdVacantion(Object idVacantion) {
        this.idVacantion = (int)(long)idVacantion;
    }

    public void setDescriptionOfVacantion(Object descriptionOfVacantion) {
        if (descriptionOfVacantion == null){
            this.descriptionOfVacantion = "-";
        } else {
            this.descriptionOfVacantion = new HtmlToPlainText().getPlainText(Jsoup.parse((String) descriptionOfVacantion));
        }
    }

    public void setCommentToVacantion(Object commentToVacantion) {
        if (commentToVacantion == null){
            this.commentToVacantion = "-";
        } else {
            this.commentToVacantion = (String) commentToVacantion;
        }
    }

    public void setProject(Object project) {
        if (project == null) {
            this.project = "-";
        } else {
            this.project = (String) project;
        }
    }

    public void setRequirementsToVacantion(Object requirementsToVacantion) {
        if (requirementsToVacantion == null) {
            this.requirementsToVacantion = "-";
        } else {
            this.requirementsToVacantion = (String) requirementsToVacantion;
        }
    }

    public void setStackOfVacantion(Object numberOfStackVacantion) {
        if (numberOfStackVacantion == "" | numberOfStackVacantion == null) {
            this.stackOfVacantion = "-";
        } else {
            this.stackOfVacantion = Stack.getParametrs(Integer.parseInt(numberOfStackVacantion.toString()));
        }
    }

    public void setGradeOfVacantion(Object numberGradeOfVacantion) {
        this.gradeOfVacantion = Grade.getParametrs(Integer.parseInt(numberGradeOfVacantion.toString()));
    }

    public void setExpirienceOfVacantion(Object numberExpirienceOfVacantion) {
        this.expirienceOfVacantion = Expirience.getParametrs(Integer.parseInt(numberExpirienceOfVacantion.toString()));
    }

    public void setAddressOfVacantion(Object addressOfVacantion) {
        if (addressOfVacantion == "" | addressOfVacantion == null) {
            this.addressOfVacantion = "-";
        } else {
            this.addressOfVacantion = (String) addressOfVacantion;
        }
    }

    public void setWorkFormatOfVacantion(Object numberWorkFormatOfVacantion) {
        this.workFormatOfVacantion = WorkFormat.getParametrs(Integer.parseInt(numberWorkFormatOfVacantion.toString()));
    }

    public void setResourceManagerOfVacantion(Object numberResourceManagerOfVacantion) {
        this.resourceManagerOfVacantion = ResourceManager.getParametrs(Integer.parseInt(numberResourceManagerOfVacantion.toString()));
    }

    public void setGeographyOfVacantion(Object geographyOfVacantion) {
        if (geographyOfVacantion == null) {
            this.geographyOfVacantion = "-";
        } else {
            this.geographyOfVacantion = (String) geographyOfVacantion;
        }
    }

    public String getNameOfVacantion() {
        return nameOfVacantion;
    }

    public int getIdVacantion() {
        return idVacantion;
    }

    public String getDescriptionOfVacantion() {
        return descriptionOfVacantion;
    }

    public String getCommentToVacantion() {
        return commentToVacantion;
    }

    public String getProject() {
        return project;
    }

    public String getRequirementsToVacantion() {
        return requirementsToVacantion;
    }

    public String getStackOfVacantion() {
        return stackOfVacantion;
    }

    public String getGradeOfVacantion() {
        return gradeOfVacantion;
    }

    public String getExpirienceOfVacantion() {
        return expirienceOfVacantion;
    }

    public String getAddressOfVacantion() {
        return addressOfVacantion;
    }

    public String getWorkFormatOfVacantion() {
        return workFormatOfVacantion;
    }

    public String getResourceManagerOfVacantion() {
        return resourceManagerOfVacantion;
    }

    public String getGeographyOfVacantion() {
        return geographyOfVacantion;
    }
    public String getCategoryOfVacanion() {
        return categoryOfVacanion;
    }

}
