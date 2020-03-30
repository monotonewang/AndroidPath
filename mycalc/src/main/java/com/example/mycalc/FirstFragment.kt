package com.example.mycalc

import android.annotation.SuppressLint
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalc.adapter.CostAdapter
import com.example.mycalc.adapter.CostClickCallBack
import com.example.mycalc.bean.CostBean
import com.example.mycalc.dao.CostDao
import com.example.mycalc.db.AppDatabase
import com.example.mycalc.utils.DateUtils
import com.example.mycalc.view_model.CostBeanViewModel
import com.example.mycalc.view_model.ViewModelFactory
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
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

    final var MAX_VALUE = 1000000;


    var list: MutableList<CostBean> = mutableListOf();

    lateinit var costDao: CostDao;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val editText = view.findViewById<AppCompatEditText>(R.id.products_search_box);
        val tvDelete = view.findViewById<TextView>(R.id.tv_delete);
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view);
        val tvFirst = view.findViewById<TextView>(R.id.textview_first);

        recyclerView.layoutManager = LinearLayoutManager(context);
        var costAdapter = CostAdapter();
        recyclerView.adapter = costAdapter;

        var costbean = CostBean();
        costbean.text = "212121212";
        costbean.datetime = DateUtils.getDateStringFormat();
        list.add(costbean);

        println("xxxxx start");

        costDao = AppApplication.getDatabase().costDao();
        val viewModelFactory = ViewModelFactory(costDao)
        val costViewModel = ViewModelProvider(this, viewModelFactory).get(CostBeanViewModel::class.java) as CostBeanViewModel;
        val insertCost = costViewModel.insertCost(costbean);
        val subscribe1 = insertCost.subscribe(object : Action {
            override fun run() {
                println("xxxxx insertCost run");

            }

        }, object : io.reactivex.functions.Consumer<Throwable> {
            override fun accept(t: Throwable?) {
                println("xxxxx insertCost$t");

            }

        })

        val allCost = costViewModel.getAllCost();
        val subscribe = costViewModel.getFirstItem()!!.onBackpressureLatest()
                .subscribe({
                    println("xxxxx firstItem=$it");
                }, {
                    println("xxxxx firstItem Error=$it");
                }
                );

        println("xxxxx allCost=$allCost");


//        val arrayListOf = arrayListOf(costbean);
        val arrayListOf = listOfNotNull(costbean);

//        costAdapter.submitList(arrayListOf);

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        });
        tvDelete.setOnClickListener {
            deleteAll().subscribe(object : Observer<List<CostBean>> {
                override fun onComplete() {
                    println("xxx onComplete" + DateUtils.getDateStringFormat())
                }

                override fun onSubscribe(d: Disposable) {
                    println("xxx onSubscribe" + DateUtils.getDateStringFormat())
                }

                override fun onNext(t: List<CostBean>) {
                    getAll();
                    println("xxx onNext" + DateUtils.getDateStringFormat())

                }

                override fun onError(e: Throwable) {
                    println("xxx onError" + DateUtils.getDateStringFormat())
                }
            });
        }
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


            }
        })
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


    }

    fun deleteAll(): Observable<List<CostBean>> {
        return Observable.create(object : ObservableOnSubscribe<List<CostBean>> {
            override fun subscribe(emitter: ObservableEmitter<List<CostBean>>) {
                costDao.deleteAll();
                emitter.onNext(arrayListOf());
                println("xxx end" + DateUtils.getDateStringFormat())
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


    }

    fun insertAll() {
        Observable.create(object : ObservableOnSubscribe<List<CostBean>> {
            override fun subscribe(emitter: ObservableEmitter<List<CostBean>>) {
                println("xxx get subscribe" + DateUtils.getDateStringFormat())
                val loadAll = costDao.loadAllSimple();
                println("xxx get ok loadAll" + DateUtils.getDateStringFormat() + "size==" + loadAll.size)
//                        emitter.onNext(loadAll)
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<CostBean>> {
                    override fun onComplete() {
                        println("xxx get onComplete" + DateUtils.getDateStringFormat())
                    }

                    override fun onSubscribe(d: Disposable) {
                        println("xxx get onSubscribe" + DateUtils.getDateStringFormat())
                    }

                    override fun onNext(t: List<CostBean>) {
//                                tvFirst.text = t.toString()
//                                println("xxx get onNext" + DateUtils.getDateStringFormat() + "size==" + t.size)

                    }

                    override fun onError(e: Throwable) {
                        println("xxx get onError" + DateUtils.getDateStringFormat())
                    }
                });
    }

    /**
     * 可以把该方法封装到ViewModel里面
     */
    fun getAll() {
        Observable.create(object : ObservableOnSubscribe<List<CostBean>> {
            override fun subscribe(emitter: ObservableEmitter<List<CostBean>>) {
                println("xxx get subscribe" + DateUtils.getDateStringFormat())
                val loadAll = costDao.loadAllSimple();
                println("xxx get ok loadAll" + DateUtils.getDateStringFormat() + "size==" + loadAll.size)
//                        emitter.onNext(loadAll)
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<CostBean>> {
                    override fun onComplete() {
                        println("xxx get onComplete" + DateUtils.getDateStringFormat())
                    }

                    override fun onSubscribe(d: Disposable) {
                        println("xxx get onSubscribe" + DateUtils.getDateStringFormat())
                    }

                    override fun onNext(t: List<CostBean>) {
//                                tvFirst.text = t.toString()
//                                println("xxx get onNext" + DateUtils.getDateStringFormat() + "size==" + t.size)

                    }

                    override fun onError(e: Throwable) {
                        println("xxx get onError" + DateUtils.getDateStringFormat())
                    }
                });
    }

    /**
     * Rxjava2 MayBe
     */
    fun maybe(){
        Maybe.create(
                object : MaybeOnSubscribe<Any> {
                    override fun subscribe(emitter: MaybeEmitter<Any>) {
//                        emitter.onError(Throwable())
//                        emitter.onComplete()
                        emitter.onSuccess("1")
                    }
                }
        ).subscribe(object : MaybeObserver<Any> {
            override fun onSuccess(t: Any) {
                println("xxxxx Maybe onSuccess");
            }

            override fun onComplete() {
                println("xxxxx Maybe onComplete");
            }

            override fun onSubscribe(d: Disposable) {
                println("xxxxx Maybe onSubscribe");
            }

            override fun onError(e: Throwable) {
                println("xxxxx Maybe onError");
            }

        })
    }
}
