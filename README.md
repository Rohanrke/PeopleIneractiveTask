# PeopleIneractiveTask

Business requirement
You have to make a project which has a card which looks alike Shaadi matches card with 2 action buttons in a recycle view and the same should be stored in a database.
On click of a button(accept/decline) on a card, the button should be replaced with a message saying member declined/member accepted and the same should be updated in the database. It should work in offline mode and the state should persist.


# Project Specification

Project is developed using MVVM Clean architecture.
Programming language - KOTLIN
App is fetching the list of results from the Network and saving them into the DB for local caching.

# Libraries used
android architecture components -- for MVVM
android JetPack -- for androidx
Retrofit -- for Network api
Koin -- for DI
Robolectric -- UI Testing
Mockito -- Mocking framework for testing
Glide -- Facebook image management library
Room -- android architecture component for local DB
Coroutines -- for Multi Threading
Espresso -- For UI testing
Chuck -- An in-app HTTP inspector for Android OkHttp clients

# Not implemented
Unit testing -- time crunch



