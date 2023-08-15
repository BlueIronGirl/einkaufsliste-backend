package com.example.einkaufsliste.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.einkaufsliste.entity.Kategorie;
import com.example.einkaufsliste.service.KategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author alice_b
 */
@ExtendWith(MockitoExtension.class)
class KategorieControllerTest {

  @Mock
  private KategorieService kategorieService;

  @InjectMocks
  private KategorieController kategorieController;

  public static final String TESTKATEGORIE_NAME = "Kategorietestname";

  private final List<Kategorie> kategorieList = new ArrayList<>();

  @BeforeEach
  public void setup() {
    kategorieList.clear();

    Kategorie kategorie = new Kategorie();
    kategorie.setName(TESTKATEGORIE_NAME);
    kategorieList.add(kategorie);

    when(kategorieService.selectAllKategorien()).thenReturn(this.kategorieList);
  }

  @Test
  void selectAllKategorien_givenKategories_thenReturnAllKategorien() {
    List<Kategorie> result = kategorieController.selectAllKategorien();

    assertEquals(result.get(0).getName(), TESTKATEGORIE_NAME);
  }

  @Test
  void selectAllKategorien_givenEmptyList_thenReturnEmptyList() {
    kategorieList.clear();

    List<Kategorie> result = kategorieController.selectAllKategorien();

    assertTrue(result.isEmpty());
  }

}
