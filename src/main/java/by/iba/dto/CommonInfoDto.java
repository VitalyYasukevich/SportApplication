package by.iba.dto;
import lombok.Data;

@Data // дает геттеры и сеттеры для всех полей, правильные реализации toString, equals и hashCode + конструктор для всех финальных полей

public class CommonInfoDto {
    private String name;
    private String phone;
    private String email;
    private String nameOffer;  // наименование услуги (Зумба, Пилатес...)
    private float price;
    private int quantityOfDay; // количество дней
    private String month;
}
