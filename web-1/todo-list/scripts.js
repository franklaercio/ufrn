function addItem() {
  var list = document.getElementById('list');
  var entry = document.getElementById('formAddTask');

  entry.onsubmit = function (evt) {
    evt.preventDefault();

    var item = document.getElementById('task').value;

    if(item !== "") {
      var li = document.createElement('li');
      var label = document.createElement('label');
      var input = document.createElement('input');
      var span = document.createElement('span');
      var task = document.createElement('span');

      input.type = 'checkbox';

      label.classList.add('task');
      span.classList.add('checkmark');
      task.classList.add('taskname');

      task.appendChild(document.createTextNode(item));
      li.appendChild(label);
      label.appendChild(input);
      label.appendChild(span);
      label.appendChild(task);

      list.appendChild(li)
    }
  }
}