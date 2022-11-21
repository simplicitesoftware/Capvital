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
| `cvFcKey`                                                    | char(255)                                | yes*     | yes       |          | -                                                                                |
| `cvFcDate`                                                   | date                                     | yes      | yes       |          | -                                                                                |
| `cvFcInvoice`                                                | char(255)                                | yes      | yes       |          | -                                                                                |
| `cvFcGrossSales`                                             | int(11)                                  | yes      | yes       |          | -                                                                                |
| `CvFinancialClaim_CvAccount_id` link to **`CvAccount`**      | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvAccount_id.cvAccountName`_         | _char(255)_                              |          |           |          | -                                                                                |
| `CvFinancialClaim_CvFinancialClaimImport_id` link to **`CvFinancialClaimImport`** | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvFinancialClaimImport_id.cvFcImportDate`_ | _datetime_                               |          |           |          | -                                                                                |

`CvFinancialClaimImport` business object definition
---------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvFcImportDate`                                             | datetime                                 | yes*     | yes       |          | -                                                                                |
| `cvFcImportStatus`                                           | enum(10) using `CV_FC_IMPORT_STATUS` list | yes      | yes       |          | -                                                                                |
| `cvFcImportFile`                                             | document                                 |          | yes       |          | -                                                                                |

### Lists

* `CV_FC_IMPORT_STATUS`
    - `KO` KO
    - `OK` OK

### Custom actions

* `CvImportAction`: 

`CvUser` business object definition
-----------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `CvUser_CvAccount_id` link to **`CvAccount`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvUser_CvAccount_id.cvAccountName`_                   | _char(255)_                              |          |           |          | -                                                                                |

`CvUserSupplier` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`CvUserAdherent` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

### Custom actions

* `resetPassword`: 

