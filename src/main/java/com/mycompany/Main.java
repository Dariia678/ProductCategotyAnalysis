package main.java.com.mycompany;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("�������", "�����������", 1200.0),
                new Product("���������", "������� �������", 80.0),
                new Product("��������", "�����������", 150.0),
                new Product("�������", "������� �������", 50.0)
        );

        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("������� ���� �� ����������: " + averagePriceByCategory);

        Optional<Map.Entry<String, Double>> maxAveragePriceCategory = averagePriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxAveragePriceCategory.ifPresent(entry ->
                System.out.println("��������� � ����� ������� ������� �����: " + entry.getKey() + " �� ������� ����� " + entry.getValue()));
    }
}
