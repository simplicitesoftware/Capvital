<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`Capvital` module definition
============================



`CvAccount` business object definition
--------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvAccountName`                                              | char(255)                                | yes*     | yes       |          | -                                                                                |

`CvFinancialClaim` business object definition
---------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvFcDate`                                                   | date                                     | yes      | yes       |          | -                                                                                |
| `cvFcInvoice`                                                | char(255)                                | yes      | yes       |          | -                                                                                |
| `cvFcChiffreAffaireHT`                                       | int(11)                                  | yes      | yes       |          | -                                                                                |
| `CvFinancialClaim_CvAccount_id` link to **`CvAccount`**      | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvAccount_id.cvAccountName`_         | _char(255)_                              |          |           |          | -                                                                                |

`CvFinancialClaimImport` business object definition
---------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvFcClaimImportDate`                                        | datetime                                 | yes      | yes       |          | -                                                                                |
| `cvFcClaimImportFile`                                        | extfile(10)                              | yes      | yes       |          | -                                                                                |

`CvUser` business object definition
-----------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvUserProfile`                                              | enum(10) using `CV_USER_PROFILE` list    | yes      | yes       |          | -                                                                                |
| `CvUser_CvAccount_id` link to **`CvAccount`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvUser_CvAccount_id.cvAccountName`_                   | _char(255)_                              |          |           |          | -                                                                                |

### Lists

* `CV_USER_PROFILE`
    - `ADH` Adherent
    - `SUP` Supplier

### Custom actions

* `resetPassword`: 

