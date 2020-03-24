package com.example.mycalc

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalc.adapter.CostAdapter
import com.example.mycalc.adapter.CostClickCallBack
import com.example.mycalc.bean.CostBean
import com.example.mycalc.dao.CostDao
import com.example.mycalc.db.AppDatabase
import com.example.mycalc.utils.DateUtils
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    var list: MutableList<CostBean> = mutableListOf();

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<AppCompatEditText>(R.id.products_search_box);
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view);
        recyclerView.layoutManager = LinearLayoutManager(context);
        var costAdapter = CostAdapter();
        recyclerView.adapter = costAdapter;

        var costbean = CostBean();
        costbean.text = "212121212";
        costbean.datetime = DateUtils.getDateStringFormat();
        list.add(costbean);

//        val arrayListOf = arrayListOf(costbean);
        val arrayListOf = listOfNotNull(costbean);

//        costAdapter.submitList(arrayListOf);

        val tvFirst = view.findViewById<TextView>(R.id.textview_first);
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        });
        view.findViewById<Button>(R.id.btn_ok).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (TextUtils.isEmpty(editText.text.toString())) {
                    Toast.makeText(context, "请输入金额大小", Toast.LENGTH_LONG).show();
                    return
                }
                //first insert sql
                var costbean = CostBean();
                costbean.text = editText.text.toString();
                costbean.datetime = DateUtils.getDateStringFormat();
                list.add(costbean);
                val costDao = AppApplication.getDatabase().costDao();


                Observable.create(object : ObservableOnSubscribe<List<CostBean>> {
                    override fun subscribe(emitter: ObservableEmitter<List<CostBean>>) {
                        var a = costDao.insert(costbean);
                        val loadAll = costDao.loadAllSimple();
                        emitter.onNext(loadAll)
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : Observer<List<CostBean>> {
                            override fun onComplete() {
                            }

                            override fun onSubscribe(d: Disposable) {
                            }

                            override fun onNext(t: List<CostBean>) {
                                tvFirst.text = t.toString()


                            }

                            override fun onError(e: Throwable) {
                            }
                        });
            }
        })
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


    }
}
