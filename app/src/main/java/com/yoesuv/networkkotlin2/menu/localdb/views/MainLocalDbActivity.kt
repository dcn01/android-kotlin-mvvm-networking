package com.yoesuv.networkkotlin2.menu.localdb.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityLocalDbBinding
import com.yoesuv.networkkotlin2.menu.localdb.viewmodels.MainLocalDbViewModel

/**
 *  Created by yusuf on 1/18/18.
 */
class MainLocalDbActivity : AppCompatActivity() {

    private lateinit var activityLocalDbBinding:ActivityLocalDbBinding
    private lateinit var localDbViewModel:MainLocalDbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        activityLocalDbBinding = DataBindingUtil.setContentView(this, R.layout.activity_local_db)
        localDbViewModel = MainLocalDbViewModel()
        activityLocalDbBinding.localDb = localDbViewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(activityLocalDbBinding.toolbarLocaldb?.toolbarInclude)
        supportActionBar?.elevation = 5f
        supportActionBar?.title = getString(R.string.list_database)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}