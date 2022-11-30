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



`CvAdherent` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvAdherentName`                                             | char(255)                                | yes*     | yes       |          | -                                                                                |

`CvFinancialClaim` business object definition
---------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvFcKey`                                                    | char(255)                                | yes*     | yes       |          | -                                                                                |
| `cvFcDate`                                                   | date                                     | yes      | yes       |          | -                                                                                |
| `cvFcInvoice`                                                | char(255)                                | yes      | yes       |          | -                                                                                |
| `CvFinancialClaim_CvAdherent_id` link to **`CvAdherent`**    | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvAdherent_id.cvAdherentName`_       | _char(255)_                              |          |           |          | -                                                                                |
| `cvFcRefProduit`                                             | char(255)                                |          | yes       |          | -                                                                                |
| `cvFcGrossSales`                                             | int(11)                                  | yes      | yes       |          | -                                                                                |
| `cvFcTVA`                                                    | int(11)                                  | yes      | yes       |          | -                                                                                |
| `cvFcTotal`                                                  | int(11)                                  | yes      | yes       |          | -                                                                                |
| `CvFinancialClaim_CvFinancialClaimImport_id` link to **`CvFinancialClaimImport`** | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvFinancialClaimImport_id.cvFcImportDate`_ | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvFinancialClaimImport_id.CvFinancialClaimImport_CvSupplier_id`_ | _id_                                     |          |           |          | -                                                                                |
| _Ref. `CvFinancialClaimImport_CvSupplier_id.cvSupplierName`_ | _char(255)_                              |          |           |          | -                                                                                |
| _Ref. `CvFinancialClaim_CvFinancialClaimImport_id.cvFcImportStatus`_ | _enum(10) using `CV_FC_IMPORT_STATUS` list_ |          |           |          | -                                                                                |

### Lists

* `CV_FC_IMPORT_STATUS`
    - `KO` KO
    - `OK` OK

`CvFinancialClaimImport` business object definition
---------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvFcImportDate`                                             | datetime                                 | yes*     | yes       |          | -                                                                                |
| `cvFcImportStatus`                                           | enum(10) using `CV_FC_IMPORT_STATUS` list | yes      | yes       |          | -                                                                                |
| `cvFcImportFile`                                             | document                                 |          | yes       |          | -                                                                                |
| `CvFinancialClaimImport_CvSupplier_id` link to **`CvSupplier`** | id                                       |          | yes       |          | -                                                                                |
| _Ref. `CvFinancialClaimImport_CvSupplier_id.cvSupplierName`_ | _char(255)_                              |          |           |          | -                                                                                |

### Lists

* `CV_FC_IMPORT_STATUS`
    - `KO` KO
    - `OK` OK

### Custom actions

* `CvImportAction`: 

`CvSupplier` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvSupplierName`                                             | char(255)                                | yes*     | yes       |          | -                                                                                |
| `cvSupplierRfa`                                              | int(11)                                  | yes      | yes       |          | -                                                                                |

`CvUser` business object definition
-----------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`CvUserAdherent` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `CvUserAdherent_CvAdherent_id` link to **`CvAdherent`**      | id                                       | yes      | yes       |          | -                                                                                |
| _Ref. `CvUserAdherent_CvAdherent_id.cvAdherentName`_         | _char(255)_                              |          |           |          | -                                                                                |

### Custom actions

* `resetPassword`: 

`CvUserSupplier` business object definition
-------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `CvUserSupplier_CvSupplier_id` link to **`CvSupplier`**      | id                                       | yes      | yes       |          | -                                                                                |
| _Ref. `CvUserSupplier_CvSupplier_id.cvSupplierName`_         | _char(255)_                              |          |           |          | -                                                                                |

### Custom actions

* `resetPassword`: 

`CvAdminDashboard` external object definition
---------------------------------------------




