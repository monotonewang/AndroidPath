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
import com.example.mycalc.bean.CostBean
import com.example.mycalc.utils.DateUtils


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
                var costbean=CostBean();
                costbean.text=editText.text.toString();
                costbean.datetime= DateUtils.getDateStringFormat();
                list.add(costbean);
                tvFirst.setText(list.toString())

            }
        })
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
