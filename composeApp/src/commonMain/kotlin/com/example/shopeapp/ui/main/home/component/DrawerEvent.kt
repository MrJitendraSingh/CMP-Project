package com.example.shopeapp.ui.main.home.component

sealed class DrawerEvent() {
    object ProfileEvent: DrawerEvent()
    object CartEvent: DrawerEvent()
    object TableEvent: DrawerEvent()
    object SofasEvent: DrawerEvent()
    object ChairsEvent: DrawerEvent()
    object CupboardsEvent: DrawerEvent()
    object MyAccountEvent: DrawerEvent()
    object StoreLocatorEvent: DrawerEvent()
    object MyOrdersEvent: DrawerEvent()
    object LogoutEvent: DrawerEvent()

}