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



`CvUser` business object definition
-----------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `cvUserProfile`                                              | enum(10) using `CV_USER_PROFILE` list    | yes      | yes       |          | -                                                                                |

### Lists

* `CV_USER_PROFILE`
    - `ADH` Adherent
    - `SUP` Supplier

