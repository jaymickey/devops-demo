using System.Collections.Generic;
using DemoApp.Models;

namespace DemoApp.ViewModels
{
    public class IndexViewModel
    {
        public List<TaskItem> AllTasks { get; set; }
        public NewTaskViewModel NewTask { get; set; }
    }
}