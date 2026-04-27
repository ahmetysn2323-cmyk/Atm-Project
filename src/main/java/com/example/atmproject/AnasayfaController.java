package com.example.atmproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AnasayfaController {

    // --- Görünüm Elemanları ---
    @FXML
    private VBox anaMenu;

    @FXML
    private VBox paraYatirPaneli;

    @FXML
    private CheckBox makbuzCheck;

    @FXML
    private TextField miktarInput; // Scene Builder'dan eklemeyi unutma

    // --- Veri ---
    private double bakiye = 1500.0; // Başlangıç bakiyesi

    // --- Sayfa Başlatma Ayarları ---
    @FXML
    public void initialize() {
        panelGoster(anaMenu); // Uygulama ana menü ile başlasın
    }

    // --- Panel Yönetimi (Yardımcı Metot) ---
    private void panelGoster(VBox gosterilecekPanel) {
        anaMenu.setVisible(false);
        anaMenu.setManaged(false);
        paraYatirPaneli.setVisible(false);
        paraYatirPaneli.setManaged(false);

        gosterilecekPanel.setVisible(true);
        gosterilecekPanel.setManaged(true);
    }

    // --- Menü Geçiş İşlemleri ---
    @FXML
    private void paraYatirmaIslemi(ActionEvent event) {
        panelGoster(paraYatirPaneli);
    }

    @FXML
    private void geriDon(ActionEvent event) {
        panelGoster(anaMenu);
    }

    // --- Banka İşlemleri ---
    @FXML
    private void paraCekmeIslemi(ActionEvent event) {
        // İleride buraya para çekme paneli eklenebilir
        bilgiMesajiGoster("Bilgi", "Para çekme sistemi şu an bakımda.");
    }

    @FXML
    private void bakiyeSorgulamaIslemi(ActionEvent event) {
        bilgiMesajiGoster("Bakiye Bilgisi", "Güncel Bakiyeniz: " + bakiye + " TL");
    }

    @FXML
    private void cikisYapIslemi(ActionEvent event) {
        System.out.println("Sistemden güvenli çıkış yapıldı.");
        System.exit(0);
    }

    // --- Onayla ve Makbuz İşlemi ---
    @FXML
    private void onayleButonTiklandi() {
        String miktarStr = miktarInput.getText();

        if (miktarStr != null && !miktarStr.isEmpty()) {
            try {
                double miktar = Double.parseDouble(miktarStr);
                bakiye += miktar; // Bakiyeyi güncelle

                bilgiMesajiGoster("Başarılı", miktar + " TL hesabınıza yatırıldı.");

                if (makbuzCheck.isSelected()) {
                    makbuzYazdir(miktar);
                }

                miktarInput.clear(); // Giriş alanını temizle
                panelGoster(anaMenu); // İşlem bitince ana menüye dön

            } catch (NumberFormatException e) {
                bilgiMesajiGoster("Hata", "Lütfen geçerli bir sayı giriniz!");
            }
        } else {
            bilgiMesajiGoster("Uyarı", "Lütfen bir miktar giriniz.");
        }
    }

    private void makbuzYazdir(double yatirilanMiktar) {
        System.out.println("------- MAKBUZ -------");
        System.out.println("İşlem Tarihi: 26.04.2026");
        System.out.println("Yatırılan: " + yatirilanMiktar + " TL");
        System.out.println("Güncel Bakiye: " + bakiye + " TL");
        System.out.println("İşlem Durumu: Başarılı");
        System.out.println("----------------------");
    }

    // Kullanıcıya bilgi vermek için Alert penceresi
    private void bilgiMesajiGoster(String baslik, String mesaj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(baslik);
        alert.setHeaderText(null);
        alert.setContentText(mesaj);
        alert.showAndWait();
    }

}