using System.Collections.Generic;
using ToDo.Web.Mvc.Models;

namespace ToDo.Web.Mvc.ViewModels
{
    public class IndexViewModel
    {
        public List<TaskItem> AllTasks { get; set; }
        public NewTaskViewModel NewTask { get; set; }
    }
}