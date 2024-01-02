import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By


@pytest.fixture
def logo():
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.w3schools.com/")
    logo = driver.find_element(By.ID, "w3-logo")
    return logo.is_diaplayed


def test_w3s(logo):
    assert logo is True
