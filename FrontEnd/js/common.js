class Login {
    constructor() {
        [
            this.username,
            this.password
        ] = [
            $(".username"),
            $(".password")
        ];
    }

    eventHandle($login, role, page) {
        $login.click(function(e) {
            const required_arr = [{
                element: login.username,
                desc: "用户名",
            }, {
                element: login.password,
                desc: "密码",
            }];
            required_arr.forEach((el) => {
                let reg = new RegExp(el.element.data("pattern"));
                if (el.element.val() === "") {
                    alert(`${ el.desc }不能为空！`);
                    throw Error(`${ el.desc }不能为空！`);
                }
                if (!reg.test(el.element.val())) {
                    alert(`${ el.desc }验证规则错误！`);
                    throw Error(`${ el.desc }验证规则错误！`);
                }
            });
            $.get(`http://localhost:8080/user/getUserMessage?username=${ login.username.val() }&password=${ login.password.val() }&role=${ role }`, function(msg) {
                if (msg) {
                    localStorage.setItem('username', login.username.val());
                    localStorage.setItem('id', msg.id);
                    localStorage.setItem("role", msg.role);
                    location.href = `${ page }`;
                } else {
                    alert("用户名或密码错误!");
                }
            })


        });
    }
}
const login = new Login();