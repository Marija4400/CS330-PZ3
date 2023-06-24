package com.example.cs330_pz3

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.cs330_pz3.data.ReceptItem
import com.example.cs330_pz3.repository.Repository
import com.example.cs330_pz3.navigation.NavigationRoutes
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AppViewModel: ViewModel() {
    lateinit var navController: NavHostController
    val repository = Repository()
    var granted = mutableStateOf(false)
    var nacinPripreme = mutableStateOf(false)

    private val _recepti = MutableLiveData<List<ReceptItem>>()
    val recepti: LiveData<List<ReceptItem>>
    get() = _recepti


    //Komunikacija sa repozitorijumom
    fun loadRecepti(){
        GlobalScope.launch {
            repository.loadRecepti()
            MainScope().launch {
                repository.receptiFlow.collect(){
                    _recepti.value=it
                }
            }
        }
    }

    fun getRecept(id:String):ReceptItem?{
        return _recepti.value?.find { it.id == id }
    }

    fun navigateToReceptDetails(id:String){
        navController.navigate(NavigationRoutes.ReceptDetailScreen.createRoute(id))
    }

    fun switchNacinPripreme(){
        nacinPripreme.value = !nacinPripreme.value
    }


    fun goBack(){
        navController.popBackStack()
    }

    fun navigateCheckedSastojak() {
        navController.navigate(NavigationRoutes.CheckedSastojak.route)
    }
}

