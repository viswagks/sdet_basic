import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()


@pytest.fixture
def geturl(url):
    driver.maximize_window()
    driver.get(url)


@pytest.fixture()
def getlogo(geturl("https://www.w3schools.com/")):
    logo = driver.find_element(By.ID, "w3-logo")
    return logo.is_diaplayed


def test_w3s(getlogo):
    assert getlogo == True