import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By


@pytest.fixture
def logo():
    global driver
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.w3schools.com/")
    yield
    driver.quit


def test_w3s(logo):
    logo = driver.find_element(By.ID, "w3-logo")
    assert logo.is_displayed() is True
