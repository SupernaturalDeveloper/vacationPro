class Register {
    zeroIze(num) {
        return num < 10 ? "0" + num : num;
    }
    getNowDate() {
        this.time = new Date();
        this.year = this.time.getFullYear();
        this.month = this.time.getMonth() + 1;
        this.date = this.time.getDate();
        this.hour = this.time.getHours();
        this.minute = this.time.getMinutes();
        this.second = this.time.getSeconds();
        return `${ this.year }-${ this.zeroIze(this.month) }-${ this.zeroIze(this.date) } ${ this.zeroIze(this.hour) }:${ this.zeroIze(this.minute) }:${ this.zeroIze(this.second) } `
    }
    clickEventHandle($username, $password, $confirm, $phone, $email, $url, $register) {
        $($register).click(function(e) {
            const required_arr = [{
                    element: $username,
                    desc: "用户名",
                }, {
                    element: $password,
                    desc: "密码",
                }, {
                    element: $confirm,
                    desc: "确认密码",
                }, {
                    element: $phone,
                    desc: "电话",
                }, {
                    element: $email,
                    desc: "邮箱",
                }, {
                    element: $url,
                    desc: "收货地址",
                }

            ];

            required_arr.forEach((el) => {
                let reg = new RegExp(el.element.data("pattern"));
                if (el.element.val() === "") {
                    alert(`${ el.desc } 不能为空！`);
                    throw Error(`${ el.desc } 不能为空！`);
                }
                if (!reg.test(el.element.val())) {
                    alert(`${ el.desc } 验证规则错误！`);
                    throw Error(`${ el.desc } 验证规则错误！`);
                }
                if ($password.val() !== $confirm.val()) {
                    alert(`密码和确认密码不一致！`);
                    throw Error(`密码和确认密码不一致！`);
                }
                if ($email.val() !== "") {
                    reg = new RegExp($email.data("pattern"));
                    if (!reg.test($email.val())) {
                        alert(`邮箱验证规则错误!`);
                        throw Error(`邮箱验证规则错误!`);
                    }
                }
            });

            $.get(`http://localhost:8080/user/insert?username=${ $username.val() }&password=${ $password.val() }&email=${ $email.val() }&phone=${ $phone.val() }&url=${ $url.val() }&role=${ $("[name=admin]:checked").val() }&createtime=${ register.getNowDate() }`, function(msg) {
                console.log(msg)
                const arr = ["普通用户", "管理员用户"];
                if (msg) {
                    alert(`${ arr[$("[name=admin]:checked").val() - 0] }注册成功!`);
                    if ($("[name=admin]:checked").val() - 0) {
                        location.href = "../html/adminLogin.html";
                    } else {
                        location.href = "../html/login.html";
                    }
                } else {
                    alert(`${ arr[$("[name=admin]:checked").val() - 0] }名已存在，请重新输入${ arr[$("[name=admin]:checked").val() - 0] }名!`);
                }
            })
        });

    }
}
const register = new Register();
register.clickEventHandle($(".username"), $(".password"), $(".confirm"), $(".phone"), $(".email"), $(".url"), $(".register"));
console.log(register.getNowDate())