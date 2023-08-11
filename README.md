# Automation Framework for Crowdar challenge

### Installation steps
> For correct installation of this framework please follow this steps:
1. Install VS Code by downloading the version you need for your operating system (Windows or Mac). The instructions are very simple and shouldn't be a problem!
1. Download JDK 19 from the official Oracle page and run the installer. The instructions are simple and shouldn't be a problem!
1. Install the Gradle Language Support and Gradle Tasks extensions in VSCode.

### Gradle Installation
##### Windows
> 1. Download Gradle from the official page
1. You can unzip the file in C: or where you prefer (I recommend directly in C). The extracted folder is renamed as gradle.
1. Opening the Control Panel -> System -> Advanced system settings -> Environment Variables … or executing the ENV command by touching the Windows magnifying glass will reach where we configure the locations of JAVA HOME, Gradle among others.
![](https://lh3.googleusercontent.com/pw/AIL4fc8f1N8McWqgkklpDvcO6Nk5lFcZ8njrJxhusInG2fzR8ZweWXUj5jFUVSYZ1A5EMkbLi0kB7JGn0rXU-q6wheA2QgyZP80VZC0HbwsmDw4ndhFxalfVCBX7tzj3rYGtQxQXff-tT61P6FtQUFRl7g4gZ9x5zciijZ-BNY4XoO8TTPm-pXyRh6Mh6CvG2EhhiCoA-M3DJPJqAnrhQxwrUDat2jwfDNbSjeWUIuHtrlgoPwYNSaqvDlbjuFep79s3KW2UhznxmVv75CMf2goc4GxWFbp_TVIPDpv0ERjTAcyH5oNGsotiTPvw1Kv3bID0cW0P3zS0UgYy0nJAG90Q6RQfzqtYgbl7OcbP_B982WjJLU925W60NdVc-iLiY_ojp5nWMLIe6LzA_ExW-w1Ap56oIgtgS9LnK5Zge0Gb9wA79l7rrqgTBn3BgPdHp_alIGUdDShu8bNiQLtBGcL7s6vWcDuJ4sV0OWJafL08sirbdCkJnpGngW691vrs95BV-M4XtV-ud0xT-ahMBQNMq1L8onoDGASK3N7ikK1tuvulToh2D11s2tz2rgntL1_rMCXmwnUy664RK1dDP5gZ2glhbJC1Q6CrAXz5GpCD_FDXlW70J0RKKW7F1emT7afs2uV0scvBCAyFyiIO0kYAZzuKBpebLSaG8ptPNDPD6VyH2iw57do4_HbP0CVr7RIm6fKh3p_jCrxFqPxeDjTt12vMqYTlQlD9T5_puOpulnl_OOvkg5wk9SHRN0qwp14I70wCzB8Qy5r5pyfLOsWUpy6M_dEhRvfGJZrrD1RZDpsoZqKjbU0z9ls1OodOdi8KRk0-lzJOXQ540y6DgSaVBzaqigdidbkL2DlgFfiffqXHfIdyUfxUyEJMeS5SiQRlvbyP_aWULYS_BqqDntgpzt4lcw=w842-h923-s-no?authuser=0)
1. Add **C:\gradle\bin** to the PATH variable
![](https://lh3.googleusercontent.com/pw/AIL4fc91UISRQSHJ_4CSnT9TlS48p2HRB83tpnU0gpKwGYFYMSJ5XdhoyRuYMJBlPFHkQoHaMeUzEOp_g9BLjqlGPPTfSPa2BZE3LhsJAKCDfulp4zwbu_ga6NUc5QgES1hxFlExwQG_DtqydCJMp_su3ohG2p_iIc3xeLyoeoeZ02LoNsFp9zRXUr46M3GsuDVoH6XLdB-F6I-1X2aD6bOp_TQyneFVKZlpxxTrfuXWpviE8BpbfdCr_i3bOUczw7sTfH3vY8O8rNdy7oHy13RGs8VEKezeFZcbV2bR_bfBYaVfmXLLPXTq27vkoIZMrPHLeZ1YU6JgUkV-lfojG9euVk1SIwMdy62KQnxTxvyar0DjXwBuW9FHLK6-1eEroaBUEMpJ__N34fczjCHb7JB9s14SF8WAVQ8CYML-8slEAqDm49Q2xtEB2aQsb8Sb_jOHrLH_8mNmk4PFGfrSCN5IVAWF8Q8fdG0TnG3NRwaTHD4PeQQdHOojf8tdh4BdmhLcDAwhWomkGt5wJHTXA5grZhB-7ZXbUTabLq97p6ik-ze6R9w6t6kpki5gmVNyUnvLDgL4bDRxcTn96kkCkggV5WKJKwPprOVY36fKB_MXWnbWUYTwrjBFLQBsyDPutOR-LYveTb1PiS5936ntLfwJ-V6OgnMzBbh7Suv30vYAhiGl7e_UJ-F8eJNxIk22G3nM3HvY4UKjeN4ReOmZJidGdyA9y_H6hzFjgEsrLWjS9Z_3AIba94CqbTn05TkyOAZedPBUuBjs7zp3f0lrsEtZkX2TRVEjGTBo2PIblWECtRUY2mO0uevqxkhwsCUre1_3W0Dm4jDFZSg-gG7fzIZs02H1Y3DgBD9eRFbJcPc_tAWR7C04UOIfsZt3jmApqx-hjyz3suv16JYS1RN7fths83Fzrg=w854-h923-s-no?authuser=0)
Windows ready!

##### Mac
> Here is easier. With Homebrew installed we are going to execute, in the terminal: brew install gradle
Mac ready!

If you have questions regarding the installation, you can contact me.

## Running Instructions
> To run the test cases, just go to the end and run the following command:

`gradle test -Dcucumber.options="--tags @API, --tags @Login, --tags @AddToCart"`

> Or you just can run manually from **app\src\test\java\runner** folder and run the respective files from there.
There are 3 runner files, one for each feature
- Login: LoginRunner.java
- API: ApiRunner.java
- Add to cart: CartRunner.java

![](https://lh3.googleusercontent.com/pw/AIL4fc8Jxao3I-O0ZkJ2kK-hMnRnxxKoIqy0qTk5jVwUsOwQpKxOrW6mJr9OVscZem6immCVr8NJZXg2HW0iWctzTNc_Wt9cEqUtXSOF-VBfrulWUYZL0lWRNbN-6HajhMsw1zXXn7cZOF4h7KXU6XUlAEkibygHwHCDc0NYzi2p7R4a_jqveeod2IGgyrsKWAZjQDF-l8WiOBpU-CDMb9IBy2LmauqAGLArloCzQ1xjNlR-GdiLvuxhWOWhWQcYhWdGWlaXVnprLrPzebwvc3N4bI8dYdOrGH54IxW66FiVdEbnGmjeCSjQpu39Fz9cpTFRliz9WdbM7QndUiOPq69x8WTtt7XNEhzN1GQZoVWd7ndAQVMZIe2T2QHf_eEWQ6F4oHhBAgRqTN_Q-iqvWl7X00tpLEqaha4Vah3abOd6ysBBSMhkv3-97gQcRxvy6-CYIZj9AAC9Pw790ci7RoiyS5Zh_B-Hr2I9U1HwCZuyKqxnl1nXpVu6uhdr0yvv2lm3N4ksIj5Biu6OG1lvWvyflhi7MB2S7jtDj4CYjOD9GeHUuwLZYfjzkBsJQu_IN2wDUV8edM2YnzlxPg7aYjZBDPz1ox7znBvtJVviY3bksNs5CcpzQ39Ddw7BTeDLfZK_vJsUoM5LVBQ8CzLu1_vmjJc5I2zdHKfp4MHCB1H0l7AjTpYa961nMfLmvpUe652-Fp-gPebuiC3MCtWgp-fr0p7YAlNUa10sCnuqGXJsaKlSTJlkbU5Z59bN3LGSioZ6M0NBL5KV6w6g0lcbSU45FEavYSXBT6RxmgoZJxJikqCV5JRZvRAEFNKBBq5D1Erz7W_79guLIDNC6dTKhErs2vBffrquVkIybO7KJ_NX_K443uBzOBd2ADQAhE3OQXKTTe6ZkhKNV7l2zgsBUUR5cNMGLQ=w1198-h620-s-no?authuser=0)

##### IMPORTANT NOTE
> Change the value of the variable 'browser' in BasePage.java class file to 'firefox' to run in FireFox Browser. 
Is 'chrome' by default.

### Reports
> For reports please see test-output folder. You can find it in: **app\test-output**

### About the framework
> The solution was developed using the following tools:
- Programming Lenguage: Java
- Automation Framework: Selenium
- Build Tool: Gradle
- API Testing: REST Assured
- IDE: VS Code
- IDE Extensions: Cucumber (Gherkin) Full Support, Debugger for Java, Extension Pack for Java, Gradle for Java, Gradle Language Support, Maven for Java, Test Runner for Java, Thunder Client, Project Manager for Java
