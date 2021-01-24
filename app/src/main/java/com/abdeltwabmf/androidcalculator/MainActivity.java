package com.abdeltwabmf.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.faendir.rhino_android.RhinoAndroidHelper;

import java.math.BigInteger;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnDot, btnProduct, btnDivision,
            btnPlus, btnMinus, btnEqual, btnComma, btnBracket, btnBackSpace,
            btnPrime, btnPower, btnSqRoot, btnPi;
    private String cur = "", operators = "+-×÷%", res = "";
    private TextView expression, result;
    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expression = (TextView) findViewById(R.id.expression);
        result = (TextView) findViewById(R.id.result);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnProduct = (Button) findViewById(R.id.btnProduct);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnComma = (Button) findViewById(R.id.btnComma);
        btnBracket = (Button) findViewById(R.id.btnBracket);
        btnBackSpace = (Button) findViewById(R.id.btnBackSpace);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDivision = (Button) findViewById(R.id.btnDivision);

        btnPi = (Button) findViewById(R.id.btnPi);
        btnPower = (Button) findViewById(R.id.btnPower);
        btnPrime = (Button) findViewById(R.id.btnPrime);
        btnSqRoot = (Button) findViewById(R.id.btnSquarRoot);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "0";
                else if (cur.charAt(0) != '0')
                    cur += "0";
                else
                    cur = "0";
                displayDigit();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "1";
                else if (cur.charAt(0) != '0')
                    cur += "1";
                else
                    cur = "1";
                displayDigit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "2";
                else if (cur.charAt(0) != '0')
                    cur += "2";
                else
                    cur = "2";
                displayDigit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "3";
                else if (cur.charAt(0) != '0')
                    cur += "3";
                else
                    cur = "3";
                displayDigit();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "4";
                else if (cur.charAt(0) != '0')
                    cur += "4";
                else
                    cur = "4";
                displayDigit();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "5";
                else if (cur.charAt(0) != '0')
                    cur += "5";
                else
                    cur = "5";
                displayDigit();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "6";
                else if (cur.charAt(0) != '0')
                    cur += "6";
                else
                    cur = "6";
                displayDigit();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "7";
                else if (cur.charAt(0) != '0')
                    cur += "7";
                else
                    cur = "7";
                displayDigit();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "8";
                else if (cur.charAt(0) != '0')
                    cur += "8";
                else
                    cur = "8";
                displayDigit();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 1)
                    cur += "9";
                else if (cur.charAt(0) != '0')
                    cur += "9";
                else
                    cur = "9";
                displayDigit();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    if (!isOperator(cur.charAt(cur.length() - 1)))
                        cur += "+";
                }
                displayDigit();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    if (!isOperator(cur.charAt(cur.length() - 1)))
                        cur += "-";
                }
                displayDigit();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    if (!isOperator(cur.charAt(cur.length() - 1)))
                        cur += "÷";
                }
                displayDigit();
            }
        });

        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    if (!isOperator(cur.charAt(cur.length() - 1)))
                        cur += "×";
                }
                displayDigit();
            }
        });

        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok = false;
                for (int i = cur.length() - 2; i >= 0; --i) {
                    if (cur.charAt(i) == '(') {
                        ok = true;
                        break;
                    } else if (isDigit(cur.charAt(i)))
                        continue;
                }
                if (ok && isDigit(cur.charAt(cur.length() - 1)))
                    cur += ", ";
                displayDigit();
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char ch;
                if (cur.length() == 0)
                    ch = '#';
                else
                    ch = cur.charAt(cur.length() - 1);

                if (isValid) {
                    if (cur.length() != 0 && (isDigit(ch) || ch == ')')) {
                        cur += ")";
                        isValid = false;
                    } else
                        cur += "(";
                } else {
                    if (cur.length() == 0 || isOperator(ch) || ch == '(') {
                        cur += "(";
                        isValid = true;
                    }
                }
                displayDigit();
            }
        });

        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    cur = cur.substring(0, cur.length() - 1);
                }
                if (cur.length() == 0) {
                    setRes("");
                    set();
                }
                displayDigit();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRes("");
                displayResult("");
                set();
                displayDigit();
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() >= 1) {
                    boolean isFloat = false;
                    for (int i = cur.length() - 1; i >= 0; --i) {
                        if (cur.charAt(i) == '.') {
                            isFloat = true;
                            break;
                        } else if (isDigit(cur.charAt(i)))
                            continue;
                        else
                            break;
                    }
                    if (!isFloat)
                        cur += ".";
                } else
                    cur = "0.";
                displayDigit();
            }
        });

        btnPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String evaluated = eval(cur);
                if (evaluated.equalsIgnoreCase("Error"))
                    displayResult("Error");
                else {
                    try {
                        displayResult(Boolean.toString(isPrime(evaluated)));
                    } catch (Exception e) {
                        displayResult("Error");
                    }
                }
                setRes("");
                set();
            }
        });

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 0) {
                    char ch = cur.charAt(cur.length() - 1);
                    if (isOperator(ch) || ch == '(') {
                        cur += "pow(";
                        isValid = true;
                    }
                } else {
                    cur = "pow(";
                    isValid = true;
                }
                displayDigit();
            }
        });

        btnSqRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 0) {
                    char ch = cur.charAt(cur.length() - 1);
                    if (isOperator(ch) || ch == '(') {
                        cur += "sqrt(";
                        isValid = true;
                    }
                } else {
                    cur = "sqrt(";
                    isValid = true;
                }
                displayDigit();
            }
        });

        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cur.length() != 0) {
                    char ch = cur.charAt(cur.length() - 1);
                    if (isOperator(ch) || ch == '(')
                        cur += Double.toString(Pi());
                } else
                    cur = Double.toString(Pi());
                displayDigit();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = eval(cur);
                displayResult(res);
                if (res.equalsIgnoreCase("Error"))
                    res = "0";
                set();
            }
        });
    }

    public void set() {
        isValid = false;
        setCur(res);
    }

    public String eval(String s) {
        s = s.replaceAll("÷", "/");
        s = s.replaceAll("×", "*");
        s = s.replaceAll("pow", "Math.pow");
        s = s.replaceAll("sqrt", "Math.sqrt");

        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);

        double answer;

        try {
            Scriptable script = rhino.initStandardObjects();
            answer = (double) rhino.evaluateString(script, s, "javascript", 1, null);

            if (answer - (long) answer == 0)
                return Long.toString((long) answer);
            else
                return Double.toString(answer);
        } catch (Exception e) {
            return "Error";
        }
    }

    public boolean isPrime(String n) {
        return new BigInteger(n).isProbablePrime(10);
    }

    public double Exponent(double n, double ex) {
        return Math.pow(n, ex);
    }

    public double sqRoot(double n) {
        return Math.sqrt(n);
    }

    public double Pi() {
        return Math.PI;
    }

    public boolean isOperator(char ch) {
        for (int i = 0; i < operators.length(); i++) {
            if (ch == operators.charAt(i))
                return true;
        }
        return false;
    }

    public void displayResult(String res) {
        result.setText(res);
    }

    public void displayDigit() {
        expression.setText(cur);
    }

    public void setRes(String s) {
        res = s;
    }

    public boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

    public void setCur(String s) {
        cur = s;
    }
}